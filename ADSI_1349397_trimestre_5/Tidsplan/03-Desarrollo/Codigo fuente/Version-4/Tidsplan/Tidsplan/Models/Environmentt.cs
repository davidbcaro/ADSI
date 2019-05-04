using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Environmentt
    {

        [Key]
        [Display(Name = "Ambiente ID")]
        public int EnvironID { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Numero de ambiente")]
        [RegularExpression("^[0-9]*$", ErrorMessage = "Solo se admiten números.")]
        [StringLength(10, ErrorMessage = "Debe tener mínimo dos caracteres, máximo diez caracteres.", MinimumLength = 2)]
        [Index("Enviromentt_numberEnvironment_Index", IsUnique = true)]
        public String numberEnvironment { get; set; }

        [Required(ErrorMessage = "Es requerido")]
        [Display(Name = "Descripción")]
        public String description { get; set; }

        [Required(ErrorMessage = "Es requerido")]
        [Display(Name = "Descripción")]
        public String toUpper
        {
            get
            {
                if (description != null)
                {
                    description = description.ToUpper();
                }
                else
                {
                    description = "Es requerido.";
                }
                return description;
            }
            set
            {
                if (description != null)
                {
                    description = description.ToUpper();
                }
                else
                {
                    description = "Es requerido.";
                }
                description.ToUpper();
            }
        }

        public virtual ICollection<Schedule> schedule { get; set; }

    }
}