using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class LearningResult
    {
        [Key]
        public int idLearningResults { get; set; }

        [Display(Name = "Id de resultado de aprendizaje")]
        [Required(ErrorMessage = "Es requerido.")]
        [MaxLength(20), MinLength(1)]
        [StringLength(20, ErrorMessage = "Debe tener mínimo dos caracteres, máximo veinte caracteres.", MinimumLength = 2)]
        [Index("LearningResult_idCode_Index", IsUnique = true)]
        public String idCode { get; set; }

        [Display(Name = "Descripción")]
        [Required(ErrorMessage = "Es requerido.")]
        [StringLength(200, ErrorMessage = "Debe tener mínimo dos caracteres, máximo doscientos caracteres.", MinimumLength = 2)]
        [Index("LearningResult_description_Index", IsUnique = true)]
        public String description { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
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

        public virtual ICollection<Trimester> trimesters { get; set; }
    }
}