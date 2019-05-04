using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Activity
    {
        [Key]
        public int idActivities { get; set; }

        [Display(Name = "Identificación de actividad")]
        [Required(ErrorMessage = "Debe tener la identificación de la actividad.")]
        [RegularExpression("^[0-9]*$", ErrorMessage = "Solo se admiten números.")]
        [StringLength(50, ErrorMessage = "Debe tener mínimo dos caracteres, máximo cincuenta caracteres.", MinimumLength = 2)]
        [Index("Activity_idActivity_Index", IsUnique = true)]
        public String idActivity { get; set; }

        
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de la actividad")]
        [StringLength(100, ErrorMessage = "Debe tener mínimo dos caracteres, máximo cien caracteres.", MinimumLength = 2)]
        [Index("Activity_name_Index", IsUnique = true)]
        public String name { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de la actividad")]
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