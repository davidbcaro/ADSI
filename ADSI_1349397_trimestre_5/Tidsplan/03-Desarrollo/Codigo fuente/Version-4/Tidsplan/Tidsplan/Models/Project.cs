using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Project
    {
        [Key]
        public int idProject { get; set; }

        [Display(Name = "Código")]
        [Required(ErrorMessage = "Es requerido.")]
        [RegularExpression("^[0-9]*$", ErrorMessage = "Solo se admiten números.")]
        [StringLength(20, ErrorMessage = "Debe tener mínimo dos caracteres, máximo veinte caracteres.", MinimumLength = 2)]
        [Index("Project_code_Index", IsUnique = true)]
        public String code { get; set; }

        [Display(Name = "Nombre de proyecto")]
        [Required(ErrorMessage = "Es requerido.")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("Project_name_Index", IsUnique = true)]
        public String name { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de proyecto")]
        public String toUpper
        {
            get
            {
                if (name != null)
                {
                    name = name.ToUpper();
                }
                else
                {
                    name = "Es requerido.";
                }
                return name;
            }
            set
            {
                if (name != null)
                {
                    name = name.ToUpper();
                }
                else
                {
                    name = "Es requerido.";
                }
                name.ToUpper();
            }
        }

        public virtual ICollection<Trimester> trimesters { get; set; }
    }
}